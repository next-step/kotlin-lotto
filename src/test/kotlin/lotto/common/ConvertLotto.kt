package lotto.common

import lotto.domain.entity.common.LottoNumber
import lotto.domain.entity.user.Lotto
import lotto.domain.entity.winning.WinningLotto

object ConvertLotto {

    fun convertUserLotto(userLottoNumber: String): List<Lotto> = listOf(
        Lotto(
            userLottoNumber
                .split(",")
                .map { LottoNumber(it.trim().toInt()) }
                .toList()
        )
    )

    fun convertWinningLotto(winningLottoNumber: String): WinningLotto = WinningLotto(
        winningLottoNumber
            .split(",")
            .map { LottoNumber(it.trim().toInt()) }
            .toList()
    )
}
