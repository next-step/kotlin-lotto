package lotto.domain

class LottoShop {

    fun buyLotto(customer: Customer): Lotto {
        val lines = mutableListOf<List<Int>>()
        repeat(getQuantity(customer.money)) {
            lines.add(LottoNumber.generate())
        }
        return Lotto(lines)
    }

    private fun getQuantity(money: Int) = money / LOTTO_FEE

    companion object {
        const val LOTTO_FEE: Int = 1_000
    }
}
