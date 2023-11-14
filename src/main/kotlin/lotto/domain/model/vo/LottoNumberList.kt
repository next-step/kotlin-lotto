package lotto.domain.model.vo

/**
 * 로또 넘버 리스트
 * */
@JvmInline
value class LottoNumberList(val numberList: List<LottoNumber>) {

    init {
        require(numberList.isNotEmpty()) {
            "로또의 번호를 골라야 합니다."
        }

        require(numberList.size == DEFAULT_LOTTO_NUMBER_LIST_LENGTH) {
            "로또의 번호 개수는 ${DEFAULT_LOTTO_NUMBER_LIST_LENGTH}개여야 합니다."
        }
    }

    override fun toString(): String {
        return numberList.toString()
    }

    companion object {

        private const val DEFAULT_LOTTO_NUMBER_LIST_LENGTH = 6

        private val primitiveLottoNumberRange = LottoNumber.MIN_NUMBER_VALUE..LottoNumber.MAX_NUMBER_VALUE

        /**
         * 원시 타입의 로또 번호 리스트 생성
         * */
        fun createPrimitiveLottoNumberList(): List<Int> {
            return primitiveLottoNumberRange.shuffled().take(DEFAULT_LOTTO_NUMBER_LIST_LENGTH).sorted()
        }

        /**
         * 로또 번호 리스트 생성
         * @param primitiveLottoNumber 원시 타임의 로또 번호 리스트
         * */
        fun valueOf(primitiveLottoNumber: List<Int>): LottoNumberList {
            return LottoNumberList(primitiveLottoNumber
                .map { number -> LottoNumber.valueOf(number) }
                .sortedBy { lottoNumber -> lottoNumber.number })
        }
    }

}
