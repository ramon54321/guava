var mainSheet;


// Components

class TableLine extends React.Component {

  constructor(props){
    super(props);
    this.state = { submitted: false, graded: false, completed: this.props.completed };
  }

  submitAssignment() {
    this.setState({
        submitted: true
    });
  }

  gradeAssignment() {
    this.setState({
        submitted: true
    });
  }

  render(){
    var self = this;
    return (
      <div className="assignmentRow">
        <div className="assignmentCell">
          <div className="textCenter">
            {function() {
              if(self.state.completed < 50){
                return (<div className="progressBar" style={{width: self.state.completed + '%'}}></div>);
              } else {
                return (<div className="progressBar danger" style={{width: self.state.completed + '%'}}></div>);
              }
            }()}
          </div>
        </div>
        <div className="assignmentCell">
          <div className="textCenter">
            {this.props.title}
          </div>
        </div>
        <div className="assignmentCell">
          <div className="textCenter">
            {this.props.dueDate}
          </div>
        </div>
        <div className="assignmentCell">
          <div className="textCenter">
            {this.props.grade}/{this.props.maxGrade}
          </div>
        </div>
        <div className="assignmentCell">
          <div className="textCenter">
            {function() {
              if(self.state.submitted){
                return ("SUBMITTED");
              } else {
                return (<div className="button small" onClick={function(){
                  mainSheet.setState(prevState => ({currentPopup:
                    <div className="popupBack">
                      <div className="sheet">
                        <h2>Submit Assignment</h2>
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
                        <div className="button" onClick={() => this.switchTo("assignments")}>LOG IN</div>
                        <div className="infoCentered">New Here? <span className="link" onClick={() => this.switchTo("signup")}>Sign Up!</span></div>
                      </div>
                    </div>}));
                }}>SUBMIT</div>);
              }
            }()}
          </div>
        </div>
      </div>
    );
  }
}

class App extends React.Component {

  constructor(props){
    super(props);
    this.state = { page: 'login', currentPopup: null};

    mainSheet = this;

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
    let self = this;
    switch (this.state.page) {
      case 'login':
        return (
          <div>
            {function(){
              if(self.state.currentPopup !== null) {
                console.log("Rendering popup!");
                return (self.state.currentPopup);
              }
            }()}
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
              <div className="button" onClick={() => this.switchTo("assignments")}>LOG IN</div>
              <div className="infoCentered">New Here? <span className="link" onClick={() => this.switchTo("signup")}>Sign Up!</span></div>
            </div>
          </div>
        );
        break;
      case 'signup':
        return(
          <div>
            {function(){
              if(self.state.currentPopup !== null) {
                console.log("Rendering popup!");
                return (self.state.currentPopup);
              }
            }()}
            <div className="spacer" style={{height: '20vh'}}></div>
            <div className="sheet">
              <h2>Sign Up</h2>
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
              <div className="field">
                <input type="password" placeholder="Confirm Password"/>
                <div className="fieldSplitter"></div>
                <i className="fa fa-key fa-2x" style={{fontSize: '20pt'}}></i>
              </div>
              <div className="field" style={{paddingLeft: '20pt'}}>
                <div style={{display: 'inline-block', marginTop: '10pt', marginLeft: '10pt'}}>Teacher Account?</div>
                <div className="fieldSplitter centered"></div>
                <input type="checkbox"/>
              </div>
              <div className="button" onClick={() => this.switchTo("login")}>SIGN UP</div>
              <div className="infoCentered">Have an Account? <span className="link" onClick={() => this.switchTo("login")}>Log In!</span></div>
            </div>
          </div>
        );
        break;
      case 'assignments':
        var assignments;

        console.log("Trying rest now");
        $.ajax({
            type: "GET",
            url: "rest/assignment",
            async: false,
            success : function(data) {
              assignments = data;
            }
        });

        return(
          <div>
            {function(){
              if(self.state.currentPopup !== null) {
                console.log("Rendering popup!");
                return (self.state.currentPopup);
              }
            }()}
            <div className="spacer" style={{height: '20vh'}}></div>
            <div className="sheet main">
              <h2>Assignments</h2>
              {assignments.map(function(obj){
                return <TableLine completed={Math.random() * 100} title={obj.title} dueDate={obj.deadline} grade="4" maxGrade={obj.maxGrade}/>;
              })}
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











// Set popup
<div className="button small" onClick={function(){
  mainSheet.setState(prevState => ({currentPopup: <div className="myPopup">POPUP</div>}));
}}>SUBMIT</div>

*/
