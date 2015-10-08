/**
 * Created by София on 09.10.2015.
 */

import lab1.PrologTable
import org.junit.Test

public class PrologTableTest extends GroovyTestCase   {

    public void TestRules() {
        assertEquals([[a, [c, b]], [b, [d]], [b, [p]]], PrologTable.parseAndFillRuleTable(['a->c&b', 'b->d|p']))
        assertEquals([], PrologTable.parseAndFillRuleTable([]))
		assertEquals([[, [b]]], PrologTable.parseAndFillRuleTable(['->b']))
		
		PrologTable.parseAndFillRuleTable(['a->'])
		Assert.Fail() // ?
    }	
	
	public void TestFindPath() {
		def prologTable = new PrologTable(['a->c&b', 'b->d|p'], ['c'])
		assertEquals(false, PrologTable.prologTable.findPath('a', 0))
        
		prologTable = new PrologTable(['a->c&b', 'b->d|p'], ['c'])
		assertEquals(true, PrologTable.prologTable.findPath('c', 0))
		
		prologTable = new PrologTable([], ['c'])
		assertEquals(true, PrologTable.prologTable.findPath('c', 0))
		
		prologTable = new PrologTable([], ['c'])
		assertEquals(false, PrologTable.prologTable.findPath('a', 0))
		
		prologTable = new PrologTable(['a->c&b'], [])
		assertEquals(false, PrologTable.prologTable.findPath('c', 0))
		
		prologTable = new PrologTable([], [])
		assertEquals(false, PrologTable.prologTable.findPath('a', 0))
		
		prologTable = new PrologTable([], [])
		assertEquals(false, PrologTable.prologTable.findPath('', 0))
	}
	
}