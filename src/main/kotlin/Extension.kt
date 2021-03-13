fun String.parseInt(): Int {
    try {
        return this.toInt()
    } catch (e: NumberFormatException) {
        throw IllegalArgumentException("자연수로 변환하는데 실패했습니다.")
    }
}
