import Data.Set 
-- terribly inefficient...
isOneToNinePerm :: [Char] -> [Char] -> Bool
isOneToNinePerm a lst
	| Prelude.null a = length lst == 9
	| (head a) == '0' = False
	| elem (head a) lst = False
	| otherwise = isOneToNinePerm (tail a) ((head a):lst)

main = do putStrLn $ show $ sum $ fromList [x * y | x <-[1..1000], y <-[1..10000], isOneToNinePerm ((show x) ++ (show y) ++ (show $ x * y)) []]
