getCollatzLength :: Integer -> Integer -> Integer
getCollatzLength num acc
	| num == 1 = acc
	| mod num 2 == 0 = getCollatzLength (div num 2) (succ acc)
	| otherwise = getCollatzLength (3 * num + 1) (succ acc)

getAnswer :: Integer -> Integer -> Integer -> Integer
getAnswer currNum highestNum highestSeq
	| currNum == 1000000 = highestNum
	| otherwise = let currSeq = getCollatzLength currNum 1
			  isHighest = currSeq > highestSeq
			  nextNum = case isHighest of True -> currNum
			  			      False -> highestNum
			  nextSeq = case isHighest of True -> currSeq
			    			      False -> highestSeq
		      in getAnswer (succ currNum) nextNum nextSeq

main = do putStrLn $ show (getAnswer 1 0 0)
