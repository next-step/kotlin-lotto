package lotto.model.data

import lotto.model.data.Lotto.Companion.toLotto

fun String.toLotto(policy: Policy) = CommaSeparatedInt(this).toLotto(policy)
