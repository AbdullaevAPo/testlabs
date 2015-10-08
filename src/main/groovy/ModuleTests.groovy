/**
 * Created by София on 09.10.2015.
 */

import lab1.PrologTable
import org.junit.Test

public class PrologTableTest extends GroovyTestCase   {

    public void TestRules() {
		assertEquals([[a, [b]]], PrologTable.parseAndFillRuleTable(['a->b']))
        assertEquals([[a, [c, b]], [b, [d]], [b, [p]]], PrologTable.parseAndFillRuleTable(['a->c&b', 'b->d|p']))
        assertEquals([], PrologTable.parseAndFillRuleTable())
		assertEquals([[, [b]]], PrologTable.parseAndFillRuleTable(['->b']))
    }	
	
	public void TestRulesEx() {
		PrologTable.parseAndFillRuleTable(['a->bb'])
		Assert.Fail("Size of elem must be equals 1") 	// ?
		
		PrologTable.parseAndFillRuleTable(['a->'])
		Assert.Fail() 	// ?
	}
	
	public void TestFacts() {
		assertEquals('a', PrologTable.parseAndFillFactTable(['a']))
		assertEquals('', PrologTable.parseAndFillFactTable([]))
	}
	
	public void TestFindPathFull() {
		def prologTable = new PrologTable(['a->c&b', 'b->d|p'], ['c'])
		assertEquals(false, PrologTable.prologTable.findPath('a', 0))
        
		prologTable = new PrologTable(['a->c&b', 'b->d|p'], ['c'])
		assertEquals(true, PrologTable.prologTable.findPath('c', 0))
	}
	
	public void TestFindPathNoRules() {
		prologTable = new PrologTable([], ['c'])
		assertEquals(true, PrologTable.prologTable.findPath('c', 0))
		
		prologTable = new PrologTable([], ['c'])
		assertEquals(false, PrologTable.prologTable.findPath('a', 0))
	}
	
	public void TestFindPathNoFacts() {
		prologTable = new PrologTable(['a->c&b'], [])
		assertEquals(false, PrologTable.prologTable.findPath('c', 0))
		
		prologTable = new PrologTable([], [])
		assertEquals(false, PrologTable.prologTable.findPath('a', 0))
		
		prologTable = new PrologTable([], [])
		assertEquals(false, PrologTable.prologTable.findPath('', 0))
	}
}