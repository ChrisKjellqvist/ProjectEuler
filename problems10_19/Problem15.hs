fact n acc
	| n == 1 = acc
	| otherwise = fact (n - 1) (acc * n)

choose n c = div (fact n 1) ((fact c 1) * (fact (n - c) 1))

main = do putStrLn $ show (choose 40 20)
