import static org.junit.Assert.*;

import org.junit.Test;

public class TestMaxPQ {
	MaxPriorityQueue<Character> mq = new MaxPriorityQueue<Character>(6);
	@Test
	public void testQueue() {
		mq.insert('P');
		mq.insert('Q');
		mq.insert('E');
		assertArrayEquals(mq.getArray(), new Character[]{null, 'Q', 'P', 'E', null, null, null});
		assertEquals(new Character('Q'), mq.deleteMax());
		mq.insert('X');
		assertArrayEquals(mq.getArray(), new Character[]{null, 'X', 'P', 'E', null, null, null});
		mq.insert('M');
		assertArrayEquals(mq.getArray(), new Character[]{null, 'X', 'P', 'E', 'M', null, null});
		mq.insert('A');
		assertArrayEquals(mq.getArray(), new Character[]{null, 'X', 'P', 'E', 'M', 'A', null});
		assertEquals(new Character('X'), mq.deleteMax());
 	}
}
