package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

class MoneyTest {
    @Test
    fun can_get_1_000won_unit(){
        assertThatThrownBy {
            Money("999")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("돈은 1000원 이상 입력해주세요")
    }

    @Test
    fun get_2_569won() {
        val money = Money("2569")

        assertThat(money.money).isEqualTo(2000)
    }

    @Test
    fun get_blank() {
        assertThatThrownBy {
            Money("")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("null값과 공백값은 입력할수없습니다.")
    }

    @Test
    fun get_null() {
        assertThatThrownBy {
            Money(null)
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("null값과 공백값은 입력할수없습니다.")
    }

    @Test
    fun get_not_int() {
        assertThatThrownBy {
            Money("a")
        }.isInstanceOf(IllegalArgumentException::class.java).hasMessageContaining("숫자만 입력해주세요")
    }

    @Test
    fun get_amount() {
        val money = Money("3000")

        val amount = money.getAmount()

        assertThat(amount).isEqualTo(3)
    }
}
