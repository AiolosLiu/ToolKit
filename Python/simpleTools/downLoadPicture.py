from selenium import  webdriver
import time
import urllib.request
from bs4 import BeautifulSoup
import html.parser

def downPicture():
    # *********  Open chrome driver and type the website that you want to view ***********************
    driver = webdriver.Chrome()
    # list the url you want to get the picture
    driver.get("https://")
    # ****************** Scroll to the bottom, and click the "view more" button *********

    def execute_times(times):
        for i in range(times):
            driver.execute_script("window.scrollTo(0, document.body.scrollHeight);")
            time.sleep(2)

            try:
                driver.find_element_by_css_selector('button.QuestionMainAction').click()
                print("page" + str(i))
                time.sleep(1)
            except:
                break

    execute_times(7)
    result_raw = driver.page_source # origin html content
    result_soup = BeautifulSoup(result_raw, 'html.parser')
    result_bf = result_soup.prettify() # structure the origin content
    print("Store raw data successfully!!!")
    noscript_nodes = result_soup.find_all('noscript') # find the node code called 'noscript'
    noscript_inner_all = ""
    for noscript in noscript_nodes:
        noscript_inner = noscript.get_text()
        noscript_inner_all += noscript_inner + "\n"
    noscript_all = html.parser.unescape(noscript_inner_all) #  store all the node
    print("Store noscript meta data successfully!!!")
    # ****************   Store meta data of imgs  *****************************************
    img_soup = BeautifulSoup(noscript_all, 'html.parser')
    img_nodes = img_soup.find_all('img')
    count = 0
    for img in img_nodes:
        if img.get('src') is not None:
            img_url = img.get('src')
            urllib.request.urlretrieve(img_url, "./output/" + str(count) + ".jpg") # download one by one 
            count += 1
    print("Store meta data and images successfully!!!")

if __name__ == '__main__':
    downPicture()
