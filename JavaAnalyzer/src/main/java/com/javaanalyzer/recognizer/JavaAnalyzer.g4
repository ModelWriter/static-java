grammar JavaAnalyzer;

whole           : line+;
line		    : (declaration | formula) (NEWLINE)?;
declaration	    : ('Class' | 'Interface' | 'Method' | 'Field') variable;
variable	    : VAR;
formula		    : '(' formula ')' | eq | in | not;
expression	    : variable | join;
join            : variable '.' variable | variable '.' join;
eq		        : expression '=' expression;
in		        : expression 'in' expression;
not		        : '!' formula;
/*closure		    : '^' expression;
reflexiveclosure: '*' expression;*/

fragment LOWERCASE  : [a-z];
fragment UPPERCASE  : [A-Z];

WHITESPACE              : (' ' | '\t')+ -> skip;
NEWLINE                 : ('\r'? '\n' | '\r')+ ;
VAR                     : (LOWERCASE | UPPERCASE | '_')+ ;
