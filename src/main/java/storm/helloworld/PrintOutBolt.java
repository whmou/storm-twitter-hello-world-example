package storm.helloworld;

import backtype.storm.task.OutputCollector;
import backtype.storm.task.TopologyContext;
import backtype.storm.topology.OutputFieldsDeclarer;
import backtype.storm.topology.base.BaseRichBolt;
import backtype.storm.tuple.Fields;
import backtype.storm.tuple.Tuple;
import twitter4j.Status;

import java.util.Map;

/**
 * Receives tweets and emits its words over a certain length.
 */
public class PrintOutBolt extends BaseRichBolt {
	
	private static final long serialVersionUID = 5151173513759399636L;

    private OutputCollector collector;

    @Override
    public void prepare(Map map, TopologyContext topologyContext, OutputCollector collector) {
        this.collector = collector;
    }

    @Override
    public void execute(Tuple input) {
        Status tweet = (Status) input.getValueByField("tweet");
        String text = tweet.getText().replaceAll("\\p{Punct}", " ").replaceAll("\\r|\\n", "");
        System.out.println(text);
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {
        declarer.declare(new Fields("text"));
    }
}
