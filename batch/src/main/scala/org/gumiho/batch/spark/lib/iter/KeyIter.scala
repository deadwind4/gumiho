
package org.gumiho.batch.spark.lib.iter

class KeyIter(iter: Iterator[Array[String]], keyColNo: Int)
    extends Iterator[(String, Array[String])] {
    override def hasNext = iter.hasNext
    override def next = {
        val col = iter.next()
        (col(keyColNo), col)
    }
}