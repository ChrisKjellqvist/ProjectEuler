-- How many distinct numbers are there in the set [a^b | 2 <= a, b <= 100]
-- I don't know a lot of Haskell but I'm happy about this solution
-- Originally completed by Chris on Mon, 29 Dec 2014, 09:38

import Data.Set

main = do putStrLn $ show $ length (Prelude.foldr (\cint_1 cset_1 -> Prelude.foldr (\cint_2 cset_2 -> insert (cint_1 ^ cint_2) cset_2) cset_1 [2..100]) Data.Set.empty [2..100])
