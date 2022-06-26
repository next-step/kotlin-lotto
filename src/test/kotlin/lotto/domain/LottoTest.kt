package lotto.domain

import io.kotest.assertions.throwables.shouldNotThrowAny
import io.kotest.assertions.throwables.shouldThrowExactly
import io.kotest.core.spec.style.StringSpec
import io.kotest.inspectors.forAll
import io.kotest.matchers.shouldBe

class LottoTest : StringSpec({
    "로또 객체를 생성한다" {
        // given
        val lottoNumbers = setOf(
            LottoNumber.valueOf(1),
            LottoNumber.valueOf(2),
            LottoNumber.valueOf(3),
            LottoNumber.valueOf(4),
            LottoNumber.valueOf(5),
            LottoNumber.valueOf(6),
        )

        // when // then
        shouldNotThrowAny { Lotto(lottoNumbers) }
    }

    "로또가 가질 수 있는 로또 숫자와 다른 로또 숫자를 가진 로또 객체를 생성하면 예외를 발생시킨다" {
        // given
        listOf(
            setOf(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
            ),
            setOf(
                LottoNumber.valueOf(1),
                LottoNumber.valueOf(2),
                LottoNumber.valueOf(3),
                LottoNumber.valueOf(4),
                LottoNumber.valueOf(5),
                LottoNumber.valueOf(6),
                LottoNumber.valueOf(7),
            )
        ).forAll {
            // when // then
            shouldThrowExactly<IllegalArgumentException> { Lotto(it) }
        }
    }

    "중복된 로또 숫자를 가진 로또 객체를 생성하면 예외를 발생시킨다" {
        // given
        val lottoNumbers = setOf(
            LottoNumber.valueOf(1),
            LottoNumber.valueOf(2),
            LottoNumber.valueOf(3),
            LottoNumber.valueOf(4),
            LottoNumber.valueOf(5),
            LottoNumber.valueOf(5),
        )

        // when // then
        shouldThrowExactly<IllegalArgumentException> { Lotto(lottoNumbers) }
    }

    "로또 숫자 객체를 생성한다" {
        listOf(
            1,
            45,
        ).forAll {
            shouldNotThrowAny { LottoNumber.valueOf(it) }
        }
    }

    "로또 숫자 범위를 벗어난 숫자로 로또 숫자 객체를 생성하면 예외를 발생시킨다" {
        listOf(
            -1,
            0,
            46,
        ).forAll {
            shouldThrowExactly<IllegalArgumentException> { LottoNumber.valueOf(it) }
        }
    }

    "두 로또가 서로 같은 로또 숫자가 몇개인지 찾는다" {
        // given
        val lotto = Lotto(1, 2, 3, 4, 5, 6)
        val otherLotto = Lotto(2, 3, 4, 5, 6, 7)

        // when
        val actual = lotto.countSameLottoNumbers(otherLotto)

        // then
        actual shouldBe 5
    }

    "캐싱된 로또 숫자를 가져온다" {
        listOf(
            1,
            45,
        ).forAll {
            // when // then
            shouldNotThrowAny { LottoNumber.valueOf(it) }
        }
    }

    "캐싱되지 않은 로또 숫자를 가져오면 예외를 발생시킨다" {
        listOf(
            0,
            46,
        ).forAll {
            // when // then
            shouldThrowExactly<IllegalArgumentException> { LottoNumber.valueOf(it) }
        }
    }
})
