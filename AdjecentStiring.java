class AdjecentString {
    public static void main(String[] args) {
        String str = "abcdcba";
        boolean isAdjecent = true;
        for (int i = 0; i < str.length() - 1; i++) {
            if (str.charAt(i) == str.charAt(i + 1)) {
                isAdjecent = false;
                break;
            }

        }
        if (isAdjecent) {
            System.out.println("The string has no adjecent characters.");
        } else {
            System.out.println("The string has adjecent characters.");
        }
    }
}
