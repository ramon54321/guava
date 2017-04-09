
// Components

class App extends React.Component {

  constructor(props){
    super(props);
    this.state = { page: 'login' };

    // Function bindings
    this.switchTo = this.switchTo.bind(this);
  }

  switchTo(pageToSwitchTo){
    this.setState(prevState => ({
      page: pageToSwitchTo
    }));
    console.log("Switched to " + pageToSwitchTo);
  }

  render(){
    switch (this.state.page) {
      case 'login':
        return (
          <div>
            <div className="spacer" style={{height: '20vh'}}></div>
            <div className="sheet">
              <h2>Log In</h2>
              <div className="field">
                <input type="text" placeholder="Username"/>
                <div className="fieldSplitter"></div>
                <i className="fa fa-user fa-2x" style={{fontSize: '20pt'}}></i>
              </div>
              <div className="field">
                <input type="password" placeholder="Password"/>
                <div className="fieldSplitter"></div>
                <i className="fa fa-key fa-2x" style={{fontSize: '20pt'}}></i>
              </div>
              <div className="button" onClick={() => this.switchTo("main")}>LOG IN</div>
              <div className="infoCentered">New Here? <span className="link" onClick={() => this.switchTo("signup")}>Sign Up!</span></div>
            </div>
          </div>
        );
        break;
      default:
        return (null);
    }
  }
}

// Final render call
ReactDOM.render(<App />, document.getElementById('react-root'));

/* Class Skeleton

class Sheet extends React.Component {

  constructor(props){
    super(props);
    this.state = { };
  }

  render(){
    return (<h2>Hello world!</h2>);
  }
}

*/
