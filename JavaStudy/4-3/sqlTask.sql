/* ■ [回答]と記載のある箇所へ、1〜8の各課題内容に沿ったSQL文を記述しなさい。 */
 
-- 1. 店舗テーブルから店舗名を抽出しなさい。また、列名の表示は別名で'店舗名'とすること。
SELECT store_name AS 店舗名 FROM store_table
https://gyazo.com/4418ae12faf75243485e06ecd75370ba
 
 
-- 2. 店舗情報を店舗名のABC順に抽出しなさい。
SELECT * FROM store_table ORDER BY store_nameAbc ASC
https://gyazo.com/c23497115e2e6bf9bdad43a86d83b1e6
 
 
-- 3. 在庫テーブルに店舗テーブル、商品テーブルを「内部結合」し、店舗名・商品名・在庫数を全て取得しなさい。
SELECT store_name, goods_name, quantity FROM stock_table AS stock
JOIN store_table AS store ON stock.store_code = store.store_code
JOIN goods_table AS goods ON stock.goods_code = goods.goods_code
https://gyazo.com/6caaaff30ce901c28fc77006e6c8a6e5
 
 
-- 4. 商品テーブルから全商品の単価の平均値を抽出しなさい。
SELECT AVG(price) FROM goods_table
https://gyazo.com/a8a5cd2b0b3d96120139cdd7e01aa13d
 
 
-- 5. 店舗コード='EA01'の在庫数の平均値より大きい在庫数を持つ店舗コードを抽出しなさい。
SELECT store_code FROM stock_table
WHERE quantity >
(SELECT AVG(quantity) FROM stock_table
WHERE store_code = 'EA01')
https://gyazo.com/df6a5758909ad082761216c806c40f46
 
 
-- 6. 商品テーブルに「商品コード='M001'、商品名='マフラー'、単価=4500円、更新日付=本日日付」のデータを追加しなさい。※実行後のSELECT結果も貼付すること。
INSERT INTO goods_table
(goods_code, goods_name, price, update_day)
VALUES('M001', 'マフラー', '4500', '2021-10-26')
 https://gyazo.com/e5b725c0f410241d1d5ece59368e2104

 
-- 7. 在庫テーブルの商品コード='S987'、かつ、店舗コード='EA01'に対して、「在庫数=10、更新日付=本日日付」で更新しなさい。※実行後のSELECT結果も貼付すること。
UPDATE stock_table
SET
quantity = 10,
update_day = '2021-10-27'
WHERE
goods_code = 'S987' AND store_code = 'EA01'
https://gyazo.com/491ff983fe2dc93ceb34649863f252ad
 
 
-- 8. 7で更新した商品を削除しなさい。※実行後のSELECT結果も貼付すること。
DELETE FROM stock_table
WHERE
goods_code = 'S987' AND store_code = 'EA01'
https://gyazo.com/4efb31c8b1b865282d093dfae4c861fb