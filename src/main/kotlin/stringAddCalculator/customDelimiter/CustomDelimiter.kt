package stringAddCalculator.customDelimiter

/**
 * 특정한 regex 를 통해 CustomDelimiter 를 식별할 수 있는 인터페이스
 * regex 결과는 항상 2개의 그룹을 반환해야 한다
 * 1) 숫자 영역
 * 2) custom delimiter
 */
interface CustomDelimiter {
    val regex: Regex

    fun parse(expression: String): ParserResult?
}
