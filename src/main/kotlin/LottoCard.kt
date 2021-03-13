data class LottoCard(val number: List<Int>) {
    override fun toString(): String {
        return number.toString()
    }
}

data class LottoCards(val cards: List<LottoCard>)
