package domain.lotto.error

object EmptyMatchResultMapException : RuntimeException() {
    private const val EMPTY_MATCH_RESULT_MAP_EXCEPTION_MESSAGE = "로또 결과가 비어있습니다."

    override val message: String = EMPTY_MATCH_RESULT_MAP_EXCEPTION_MESSAGE
}
