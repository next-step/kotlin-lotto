package lotto.model

import lotto.model.data.Lotto
import org.assertj.core.util.VisibleForTesting

@VisibleForTesting
class StringLottoBuilder(private val numberString: String) : LottoBuilder {

    override fun createLotto() = Lotto(
        numberString.split(",")
            .map { it.trim().toInt() }
            .toSet()
    )
}
