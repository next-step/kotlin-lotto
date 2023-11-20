class StringAddCalculator {

    fun add(text: String?): Int {
        if (text.isNullOrBlank()) return 0

        var txt: String = text
        val separators: MutableList<String> = mutableListOf(",", ":")

        if (txt[0] == '/' && txt[1] == '/'/* && txt[3] == '\' && txt[4] == 'n'*/) {
            separators.add(txt[2].toString())
            txt = txt.substring(4)
        }

        return txt.split(*separators.toTypedArray()).map { it.toInt() }.let { numbers: List<Int> ->
            if (numbers.any { it < 0 }) throw RuntimeException("문자열 계산기에 음수는 전달할 수 없습니다.")
            numbers.sum()
        }
    }
}
