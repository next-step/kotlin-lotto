package lotto.ticket

import lotto.ticket.LottoNumber.Companion.LOTTO_NUMBER_BOX

interface LottoDrawPolicy {

    fun applyDrawPolicy(): Set<LottoNumber>

    fun draw(): Set<LottoNumber> {
        val lottoNumbers = applyDrawPolicy()
            .take(TICKET_SIZE)
            .toSet()

        require(TICKET_SIZE == lottoNumbers.size) { "로또는 $TICKET_SIZE 만큼 뽑아야 합니다." }
        return lottoNumbers
    }

    companion object {
        private const val TICKET_SIZE = 6
    }
}

class AutoDrawPolicy : LottoDrawPolicy {
    override fun applyDrawPolicy(): Set<LottoNumber> = LOTTO_NUMBER_BOX.values.shuffled().toSet()
}

class ManualDrawPolicy(txNumbers: String) : LottoDrawPolicy {

    private val numbers = txNumbers.split(LOTTO_NUMBER_DELIMITER)
        .map { it.trim().toInt() }

    override fun applyDrawPolicy(): Set<LottoNumber> = numbers
        .map { LOTTO_NUMBER_BOX[it] ?: throw IllegalArgumentException("로또번호($it)로 사용할 수 없습니다.") }
        .toSet()

    companion object {
        private const val LOTTO_NUMBER_DELIMITER = ","
    }
}
