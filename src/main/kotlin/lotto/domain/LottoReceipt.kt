package lotto.domain

data class LottoReceipt(
    val manual: List<Lotto>,
    val auto: List<Lotto>
) {
    val size = manual.size + auto.size
    val lottos = manual + auto
}
