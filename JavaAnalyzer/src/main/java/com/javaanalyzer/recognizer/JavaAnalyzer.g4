grammar JavaAnalyzer;

input           : line+;
line		    : (declaration | formula) (NEWLINE)?;
declaration	    : type VAR;
type           : 'Class' | 'Interface' | 'Method' | 'Field' | ('Object')?;
formula		    : '(' formula ')'                   #PHARANTHESSEDFORMULA
                    | expression '=' expression     #EQUAL
                    | expression 'in' expression    #IN
                    | 'no' expression               #NO
                    | 'some' expression             #SOME
                    | 'one' expression              #ONE
                    | 'lone' expression             #LONE
                    | '!' formula                   #NOT
                    | formula '||' formula          #OR
                    | formula '&&' formula          #AND;
expression	    :   VAR                             #VARIABLE
                    | '(' expression ')'            #PHARANTHESSEDEXPRESSION
                    | expression '.' expression     #JOIN
                    | '*' expression                #REFLEXIVECLOSURE
                    | '^' expression                #CLOSURE
                    | expression '+' expression     #UNION
                    | '~' expression                #TRANSPOSE
                    ;

fragment ALPHA  : [a-zA-Z];
fragment ALPHANUMERIC  : [a-zA-Z0-9];

WHITESPACE              : (' ' | '\t')+ -> skip;
NEWLINE                 : ('\r'? '\n' | '\r')+ ;
VAR                     : ALPHA ((ALPHANUMERIC | '_')+)? ;