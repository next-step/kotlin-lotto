package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import java.util.Queue
import java.util.LinkedList

class LottoTests {
    @Test
    fun `로또 생성시 6개의 숫자를 가지고 있어야 한다`() {
        val lotto: Lotto = Lotto(generator = 순차적으로_증가하는_로또번호_제너레이터())

        assertThat(lotto.numbers.size)
            .isEqualTo(6)
    }

    @Test
    fun `로또 생성시 제너레이터에 의존해야한다`() {
        val lotto: Lotto = Lotto(generator = 순차적으로_증가하는_로또번호_제너레이터())

        assertThat(lotto.numbers)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    @Test
    fun `로또 번호와 당첨번호와 매칭하여 가져와야 한다`() {
        val lotto: Lotto = Lotto(generator = 순차적으로_증가하는_로또번호_제너레이터())

        val rank: Rank = lotto.matchByWonNumber(
            arrayListOf(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(44),
                LottoNumber(45)
            )
        )

        assertThat(rank)
            .isEqualTo(Rank.getRankByCount(4))

        assertThat(lotto.numbers)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }
    @Test
    fun `로또의 숫자는 중첩이 불가능하다 마지막 숫자인 6이 맨 끝에 있으므로 queue는 empty가 되어야 한다`() {
        var queue: Queue<Int> = LinkedList()
        queue.addAll(arrayOf(1, 2, 3, 1, 4, 2, 1, 2, 3, 1, 4, 5, 1, 1, 4, 3, 2, 5, 6))

        val 중첩된숫자가쫀재하는제너레이터 = 중첩된_숫자가_쫀재하는_제너레이터(queue)

        val lotto: Lotto = Lotto(generator = 중첩된숫자가쫀재하는제너레이터)

        assertThat(queue.isEmpty())
            .isTrue()
        assertThat(lotto.numbers.size)
            .isEqualTo(6)
        assertThat(lotto.numbers)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    @Test
    fun `로또 번호와 당첨번호와 매칭하여 가져와야 한다`() {
        val lotto: Lotto = Lotto(generator = 순차적으로_증가하는_로또번호_제너레이터())

        val rank: Rank = lotto.matchByWonNumber(
            LottoWonNumbers(setOf(1, 2, 3, 4, 44, 45), 43)
        )

        assertThat(rank)
            .isEqualTo(Rank.getRankByCount(4, false))

        assertThat(lotto.numbers)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    @Test
    fun `로또의 숫자는 중첩이 불가능하다 마지막 숫자인 6이 맨 끝에 있으므로 queue는 empty가 되어야 한다`() {
        var queue: Queue<Int> = LinkedList()
        queue.addAll(arrayOf(1, 2, 3, 1, 4, 2, 1, 2, 3, 1, 4, 5, 1, 1, 4, 3, 2, 5, 6))

        val 중첩된숫자가쫀재하는제너레이터 = 중첩된_숫자가_쫀재하는_제너레이터(queue)

        val lotto: Lotto = Lotto(generator = 중첩된숫자가쫀재하는제너레이터)

        assertThat(queue.isEmpty())
            .isTrue()
        assertThat(lotto.numbers.size)
            .isEqualTo(6)
        assertThat(lotto.numbers)
            .containsExactlyInAnyOrder(
                LottoNumber(1),
                LottoNumber(2),
                LottoNumber(3),
                LottoNumber(4),
                LottoNumber(5),
                LottoNumber(6)
            )
    }

    @Test
    fun `5개가 맞고, 1개의 보너스가 맞으면은 2등이다 `() {
        val lotto: Lotto = Lotto(generator = 순차적으로_증가하는_로또번호_제너레이터())

        val rank: Rank = lotto.matchByWonNumber(LottoWonNumbers(setOf(1, 2, 3, 4, 44, 45), 43))

        val wonNumbers: LottoWonNumbers = LottoWonNumbers(setOf(1, 2, 3, 4, 5, 10), 6)

        assertThat(lotto.matchByWonNumber(wonNumbers))
            .isEqualTo(Rank.SECOND)
    }

    fun 순차적으로_증가하는_로또번호_제너레이터(): LottoNumberGenerator {
        return object : LottoNumberGenerator {
            private var increase: Int = 1

            override fun pickNumber(): Int = increase++
        }
    }

    fun 중첩된_숫자가_쫀재하는_제너레이터(queue: Queue<Int>): LottoNumberGenerator {
        return object : LottoNumberGenerator {
            override fun pickNumber(): Int = queue.poll()
        }
    }
    fun 중첩된_숫자가_쫀재하는_제너레이터(queue: Queue<Int>): LottoNumberGenerator {
        return object : LottoNumberGenerator {
            override val number: Int
                get() = queue.poll()
        }
    }
}
