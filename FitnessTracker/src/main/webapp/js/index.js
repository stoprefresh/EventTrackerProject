{/* <div id="bodyContent">   
       <div id="title"></div>
       <div id="contentHeader"></div>
       <div id="contentBody"></div>
       <div id="footer"></div>
    </div>  */}


window.addEventListener('load', function(e) {
    console.log('document loaded');
    
  });




  function getAllEntries(){
    const url = `api/entries/all`;
    const xhr = new XMLHttpRequest();

    xhr.open('GET', url, true);

    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            let entries = JSON.parse(xhr.responseText);
            console.log(entries);
        }
    };
    xhr.send(null);
  }



  function getEntryById(entryId){
    const url = `api/entry/${entryId}`;
    const xhr = new XMLHttpRequest();

    xhr.open('GET', url, true);

    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            let entries = JSON.parse(xhr.responseText);
            console.log(entries);
        }
    };
    xhr.send(null);
  }


  
  function getEntriesByKeyword(keyword){
    const url = `api/entries/search/${keyword}`;
    const xhr = new XMLHttpRequest();

    xhr.open('GET', url, true);

    xhr.onreadystatechange = () => {
        if(xhr.readyState === 4) {
            let entries = JSON.parse(xhr.responseText);
            console.log(entries);
        }
    };
    xhr.send(null);
  }


  function deleteEntryById(entryId){
    const url = `api/entry/${entryId}`;
    const xhr = new XMLHttpRequest();

    xhr.open('DELETE', url, true);

    xhr.send(null);
  }







