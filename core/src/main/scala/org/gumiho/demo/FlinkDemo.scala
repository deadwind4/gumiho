package org.gumiho.demo

import java.util.Properties

import org.apache.flink.api.common.serialization.SimpleStringSchema
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment
import org.apache.flink.streaming.connectors.kafka.FlinkKafkaConsumer010
import org.apache.flink.streaming.api.scala._
import org.apache.flink.streaming.connectors.fs.SequenceFileWriter
import org.apache.flink.streaming.connectors.fs.bucketing.{BucketingSink, DateTimeBucketer}
import org.gumiho.lib.FlinkSink

object FlinkDemo {
    def main(args: Array[String]): Unit = {
        val bootstrap = "localhost:9092"
        val group = "foo-group"
        val topic = "foo-topic"
        val env = StreamExecutionEnvironment.getExecutionEnvironment
        val properties = new Properties()
        properties.setProperty("bootstrap.servers", bootstrap)
        properties.setProperty("group.id", group)
        val stream = env
            .addSource(
                new FlinkKafkaConsumer010[String](
                    topic,
                    new SimpleStringSchema(),
                    properties
                )
            )

        val sink = FlinkSink.HdfsSink()
        stream.addSink(sink)
        env.execute("hh")
    }
}
