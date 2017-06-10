package org.lafzi.kotlinguideoffline.markdownStyles

import br.tiagohm.markdownview.css.styles.Github

/**
 * Created by alfat on 27/05/17.
 */

class GithubStyleExtended : Github() {
    init {
        removeRule("body")
        addRule("body", "line-height: 1.6", "padding: 0px")
    }
}