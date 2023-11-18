package lotto.domain

import lotto.data.LottoNumber

class RandomLogic : RandomLogicInterface {

    override fun createAutoLotto(numbers: Map<Int, LottoNumber>): Set<LottoNumber> {

        return LinkedHashSet(numbers.values.shuffled().subList(SUB_LIST_START_POSITION, LOTTO_NUMBER_LENGTH))
    }

    companion object {
        private const val SUB_LIST_START_POSITION = 0
        private const val LOTTO_NUMBER_LENGTH = 6
    }
}
