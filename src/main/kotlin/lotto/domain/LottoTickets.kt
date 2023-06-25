package lotto.domain

const val LOTTO_SIZE = 6

data class LottoTickets(val values: List<LottoNumbers>) {
    init {
        for (numbers in values) {
            require(numbers.values.size == LOTTO_SIZE) {
                "LottoTickets 의 모든 ticket 은 6개의 숫자를 포함해야 합니다. 입력 값: [${numbers.values.size}]"
            }
        }
    }
}
