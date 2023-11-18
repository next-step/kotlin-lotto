package lotto.domain

import lotto.data.LottoNumber

class RandomLogic : RandomLogicInterface {
    override fun createRandomLotto(numbers: Map<Int, LottoNumber>): LinkedHashSet<LottoNumber> {
        val randomNumberList = numbers.values.shuffled()
            .subList(SUB_LIST_START_POSITION, SUB_LIST_START_POSITION + LOTTO_NUMBER_LENGTH)
        return LinkedHashSet(randomNumberList)
    }

    companion object {
        private const val SUB_LIST_START_POSITION = 0
        private const val LOTTO_NUMBER_LENGTH = 6
    }
}
