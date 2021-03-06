package org.gumiho.demo.lang

import org.gumiho.lib.ConfUtils
import scala.collection.JavaConverters._

object ConfDemo {
    def main(args: Array[String]): Unit = {
        val p = ConfUtils.readProperties("foo.properties")
        val iters = p.entrySet().iterator().asScala
        for (i <- iters) {
            println(i.getKey, i.getValue)
        }
    }
}
