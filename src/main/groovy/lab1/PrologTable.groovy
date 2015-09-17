package lab1
/**
 * Created by ali on 16.09.15.
 */
public class PrologTable {
    def ruleTable = [];
    def facts = [];

    PrologTable(stringArgs, facts){
        parseAndFillRuleTable(stringArgs);
        parseAndFillFactTable(facts);
    }

    def parseAndFillRuleTable(stringRules) {
        stringRules.each { arg ->
            def values = arg.split('->|\\|');
            values[1..values.length - 1].each { spel ->
                def realValues = spel.split('&').each { spel2 ->
                    if (spel2.size() != 1 || !spel2.charAt(0).isLetter())
                        throw new IllegalArgumentException('Size of elem must be equals 1')
                }
                ruleTable.add([values[0], realValues]);
            }
        }
    }

    def parseAndFillFactTable(facts) {
        facts.each { fact ->
            if (fact.size() != 1 || !fact.charAt(0).isLetter())
                throw new IllegalArgumentException('Size of fact must be equals 1')
        }
        this.facts = facts;

    }

    def findPath(String goal, int recursionCount) {
        if (null != facts.find { fact -> fact == goal }) return true;

        def exit = false, exit2 = false;
        ruleTable.find { rule ->
            exit = true
            if (rule[0] == goal)
                rule[1].each { localRule -> if (exit && !findPath(localRule, recursionCount++)) exit = false }
            else return false
            exit
        } != null
    }

    def getTable() {
        return ruleTable
    }
}
