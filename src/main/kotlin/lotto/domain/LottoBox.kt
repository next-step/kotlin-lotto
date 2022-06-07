package lotto.domain

class LottoBox {
    private val lottoNums: MutableMap<Int, LottoNum>

    init {
        val intRange = 1..45

        lottoNums = intRange
            .map { LottoNum(it) }
            .associateBy { it.num }
            .toMutableMap()
    }

    fun getLottoNum(num: Int): LottoNum {
        val lottoNum = lottoNums[num]
        require(lottoNum != null) {
            "로또 숫자는 중복해서 입력할 수 업습니다"
        }

        lottoNums.remove(lottoNum.num)
        return lottoNum
    }
}
