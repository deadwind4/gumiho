package org.gumiho.lib.spark.ml

import org.apache.spark.ml.feature.StandardScaler

object Utils {
    def standardScaler() = {
        new StandardScaler()
            .setInputCol("features")
            .setOutputCol("scaledFeatures")
            .setWithMean(true)
            .setWithStd(true)
    }
}
