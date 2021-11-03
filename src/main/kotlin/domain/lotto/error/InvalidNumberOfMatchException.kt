package domain.lotto.error

import domain.lotto.domain.Lotto

class InvalidNumberOfMatchException(private val element: Int) : RuntimeException() {
    override val message: String
        get() = INVALID_LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE.format(element)

    companion object {
        private const val INVALID_LOTTO_NUMBER_SIZE_EXCEPTION_MESSAGE =
            "맞은 로또의 개수 %s 은 ${Lotto.MINIMUM_SIZE} 과 ${Lotto.MAXIMUM_SIZE} 사이의 숫자가 아니다."
    }
}