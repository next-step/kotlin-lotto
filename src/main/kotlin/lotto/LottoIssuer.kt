package lotto

class LottoIssuer : LottoIssuable {

    override fun issue(): Lotto {
        return Lotto(listOf(1, 2, 3, 4, 5, 6))
    }
}
