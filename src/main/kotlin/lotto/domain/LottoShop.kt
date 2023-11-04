package lotto.domain

class LottoShop {

    fun buyLotto(customer: Customer) =
        Lotto(customer.money)

}
