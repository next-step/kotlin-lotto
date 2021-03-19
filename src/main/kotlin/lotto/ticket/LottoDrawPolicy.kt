package lotto.ticket

import lotto.ticket.LottoNumber.Companion.LOTTO_NUMBER_BOX

interface LottoDrawPolicy {

    val lottoNumbers: Set<LottoNumber>

    fun draw(): Set<LottoNumber> {
        val lottoNumbers = this.lottoNumbers
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
    override val lottoNumbers: Set<LottoNumber> = LOTTO_NUMBER_BOX.values.shuffled().toSet()
}

class ManualDrawPolicy(txNumbers: String) : LottoDrawPolicy {

    override val lottoNumbers: Set<LottoNumber> = txNumbers.split(LOTTO_NUMBER_DELIMITER)
        .map { it.toInt() }
        .map { LOTTO_NUMBER_BOX[it] ?: throw IllegalArgumentException("로또번호($it)로 사용할 수 없습니다.") }
        .toSet()

    companion object {
        private const val LOTTO_NUMBER_DELIMITER = ","
    }
}
