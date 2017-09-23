public class encryption{
	/** String used to encrypt the given password from user */
	private String encryption;
	
	/** Password given by user to encrypt */
	private String userPass;
	
	/** Minimum length for password */
	private int minLength;
	
	/** Maximum length for password */
	private int maxLength;
	
	public encryption () {
		this.encryption = "";
		this.userPass = "";
		this.minLength = 8;
		this.maxLength = 16;
	}
	
	public void setEncrpytion (String encryption) {
		if (encryption == "") {
			System.out.println("No encryption entered.");
		} else {
			this.encryption = encryption;
		}
	}

	public void setUserPass (String givenPass) {
		if (givenPass.length() < this.minLength) {
			System.out.println("Given password is too short.");
		} else if (givenPass.length() > this.maxLength) {
			System.out.println("Given password is too long.");
		} else {
			this.userPass = givenPass;
		}
	}
	
	public void setMinLength (int value) {
		this.minLength = value;
	}
	
	public void setMaxLength (int value) {
		this.maxLength = value;
	}
	
	public String encrpyt () {
		String result = "";
		int userCount = 0;
		int encryptCount = 0;
		while (userCount < this.userPass.length()) {
			if (encryptCount == this.encryption.length()) {
				encryptCount = 0;
			}
			int asciiValue = (int) this.userPass.charAt(userCount) + (int) this.encryption.charAt(encryptCount);
			if (Character.isUpperCase(this.userPass.charAt(userCount))) {
				while (asciiValue > 90) {
					asciiValue -= 26;
				}
			} else if (Character.isLowerCase(this.userPass.charAt(userCount))) {
				while (asciiValue > 122) {
					asciiValue -= 26;
				}
			} else {
				while (asciiValue > 57) {
					asciiValue -= 10;
				}
			}
			result = result + (char) asciiValue;
			userCount += 1;
			encryptCount += 1;
		}
		return result;
	}
	
	public String decrypt (String encrypted, String key) {
		String result = "";
		int encryptCount = 0;
		int keyCount = 0;
		while (encryptCount < encrypted.length()) {
			if (keyCount == key.length()) {
				keyCount = 0;
			}
			int asciiValue = (int) encrypted.charAt(encryptCount) - (int) key.charAt(keyCount);
			if (Character.isUpperCase(encrypted.charAt(encryptCount))) {
				while (asciiValue < 65) {
					asciiValue += 26;
				}
			} else if (Character.isLowerCase(encrypted.charAt(encryptCount))) {
				while (asciiValue < 97) {
					asciiValue += 26;
				}
			} else {
				while (asciiValue < 48) {
					asciiValue += 10;
				}
			}
			result = result + (char) asciiValue;
			encryptCount += 1;
			keyCount += 1;
		}
		return result;
	}
	
	public static void main (String[] args) {
		encryption test = new encryption();
		test.setUserPass("DickyZeng212");
		test.setEncrpytion("A2fas2eD2");
		System.out.println(test.userPass + " -> " + test.encrpyt() + " via " + test.encryption);
		System.out.println(test.encrpyt() + " -> " + test.decrypt(test.encrpyt(), test.encryption) + " via " + test.encryption);
	}
}
