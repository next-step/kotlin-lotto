package lotto.model

import lotto.model.data.Lotto
import lotto.model.data.Lotto.Companion.toLotto
import lotto.util.toBlankRemovedIntList
import org.assertj.core.util.VisibleForTesting

@VisibleForTesting
class StringLottoBuilder(private val numberString: String) : LottoBuilder {
    override fun createLotto(): Lotto {
        return numberString.toBlankRemovedIntList()
            .toLotto()
    }
}
