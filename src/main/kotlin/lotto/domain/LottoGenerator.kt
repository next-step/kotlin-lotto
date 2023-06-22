package lotto.domain

interface LottoGenerator {

    /**
     * 전달 받은 수만큼 로또를 생성한다.
     */
    fun generate(amount: Int): List<Lotto>
}