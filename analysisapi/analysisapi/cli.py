from fastapi import FastAPI, HTTPException
import httpx
import xml.etree.ElementTree as ET
import uvicorn

def load_diary_api_url(file_path="config.xml"):
    """
    XMLファイルからAPIのURLを取得する
    """
    try:
        tree = ET.parse(file_path)
        root = tree.getroot()
        url = root.find("diary_api_url").text
        return url
    
    except Exception as e:
        raise RuntimeError(f"XMLの読み込みに失敗しました: {e}")

def foo(diary, text="Pythonから追記しました。"):
    """
    この箇所でAI解析を行う。一時的にfoo関数で代用。
    """
    if "content" in diary:
        diary["content"] += text
        
    return diary

app = FastAPI()

@app.get("/diary/{id}")
async def get_diary(id: int):
  """
  Spring BootのAPIから指定idの日記を取得し、文末に文章を追加
  """

  # xmlから取得した日記apiへのurlを設定
  DIARY_API_URL = load_diary_api_url()

  # urlを組み立てる
  url = f"{DIARY_API_URL}/{id}"

  # 非同期処理でSpring Bootのapiを呼び出し
  async with httpx.AsyncClient() as client:
    response = await client.get(url)
  
  # ステータスコードが200以外の場合はエラーを返す
  if response.status_code != 200:
    raise HTTPException(status_code=response.status_code, detail="Spring Boot APIエラー")

  diary = response.json()

  if not diary:
    raise HTTPException(status_code=404, detail="指定した日付の日記が見つかりません")

  # この箇所でAI解析を行う
  diary = foo(diary)

  return diary

def main():
  # uvicornでFastAPIアプリを起動
  uvicorn.run(app, host="127.0.0.1", port=8000)
