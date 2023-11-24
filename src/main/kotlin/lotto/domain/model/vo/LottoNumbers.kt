package lotto.domain.model.vo

/**
 * 로또 넘버 리스트
 * */
@JvmInline
value class LottoNumbers(val numbers: Set<LottoNumber>): Set<LottoNumber> by numbers {

    init {
        require(numbers.isNotEmpty()) {
            "로또번호들은 비어 있을 수 없습니다."
        }

        require(numbers.size == DEFAULT_LOTTO_NUMBER_LIST_LENGTH) {
            "로또의 번호 개수는 ${DEFAULT_LOTTO_NUMBER_LIST_LENGTH}개여야 합니다."
        }
    }

    override fun toString(): String {
        return numbers.toString()
    }

    companion object {

        private const val DEFAULT_LOTTO_NUMBER_LIST_LENGTH = 6

        private val primitiveLottoNumberRange = LottoNumber.MIN_NUMBER_VALUE..LottoNumber.MAX_NUMBER_VALUE

        /**
         * 원시 타입의 로또 번호 리스트 생성
         * */
        fun createPrimitiveLottoNumberList(): Set<Int> {
            return primitiveLottoNumberRange.shuffled().take(DEFAULT_LOTTO_NUMBER_LIST_LENGTH).sorted().toSet()
        }

        /**
         * 로또 번호 리스트 생성
         * @param primitiveLottoNumber 원시 타임의 로또 번호 리스트
         * */
        fun valueOf(primitiveLottoNumber: Set<Int>): LottoNumbers {
            return LottoNumbers(primitiveLottoNumber
                .map { number -> LottoNumber.valueOf(number) }
                .sortedBy { lottoNumber -> lottoNumber.number }.toSet())
        }
    }

}
