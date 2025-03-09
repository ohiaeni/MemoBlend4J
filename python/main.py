from fastapi import FastAPI, HTTPException
import httpx

app = FastAPI()

DIARY_API_URL = "http://localhost:8080/api/diary"

@app.get("/diary/{id}")
async def get_diary(id: int):
    """
    Spring BootのAPIから指定idの日記を取得し、文末に文章を追加
    """

    # URLを組み立てる
    url = f"{DIARY_API_URL}/{id}"

    # 非同期処理でSpring BootのAPIを呼び出し
    async with httpx.AsyncClient() as client:
        response = await client.get(url)
    
    # ステータスコードが200以外の場合はエラーを返す
    if response.status_code != 200:
        raise HTTPException(status_code=response.status_code, detail="Spring Boot APIエラー")

    diary = response.json()

    if not diary:
        raise HTTPException(status_code=404, detail="指定した日付の日記が見つかりません")

    diary["content"] += "Pythonから追記しました。"

    return diary
