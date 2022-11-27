package calculator.extensions


fun String.removeCustomRegex(): String {
    return replace("//", "").replace("\n", "")
}

