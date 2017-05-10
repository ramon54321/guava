var mainSheet;

var isStudent = null;

// Components

class TableLineSubmission extends React.Component {

  constructor(props){
    super(props);
    this.state = {};
  }

  gradeSubmission() {

    var grade = $("#gradingGrade").val();
    var submissionId = this.props.id;

    console.log("Trying rest now - grading assignment");
    $.ajax({
        type: "PUT",
        url:  "rest/submission/" + submissionId + "/grade/" +  grade,
        async: false,
        success : function(data) {
          console.log(data);
        }
    });

    mainSheet.setState(prevState => ({currentPopup: null}));
  }

  render(){
    var self = this;
    return (
      <div className="assignmentRow">
        <div className="assignmentCell">
          <div className="textCenter">
            {this.props.user}
          </div>
        </div>
        <div className="assignmentCell">
          <div className="textCenter">
            {this.props.course}
          </div>
        </div>
        <div className="assignmentCell">
          <div className="textCenter">

          </div>
        </div>
        <div className="assignmentCell">
          <div className="textCenter">
            {gradeSubmission()}/5
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
                        <div className="headerExit" onClick={() => mainSheet.switchTo("submissions")}>X</div>
                        <div className="field">
                          <textarea placeholder="Comment"/>
                        </div>
                        <div className="field">
                          <input type="text" placeholder="Grade" id="gradingGrade"/>
                        </div>
                        <div className="button" onClick={() => self.gradeSubmission()}>RETURN SUBMISSION</div>
                        <div className="infoCentered">Need help submitting? <span className="link">Click Here.</span></div>
                      </div>
                    </div>}));
                }}>RETURN</div>);
              }
            }()}
          </div>
        </div>
      </div>
    );
  }
}

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

  submitSubmission() {

    var newSubmission = {
      id: this.props.id,
      assignmentId: this.props.id,
      studentUserId: "0",
      answer: "This is my answer to the assignment on some assignment.",
      submittedDate: "2012-04-23"
    };

    console.log("Trying rest now");
    $.ajax({
        type: "POST",
        url:  "rest/submission" ,
        contentType: 'application/json',
        data: JSON.stringify(newSubmission),
        async: false,
        success : function(data) {
          console.log(data);
        }
    });

    mainSheet.setState(prevState => ({currentPopup: null}));
  }

  getGrade() {
    var grade = 0;
    console.log("Getting submission grade");
    $.ajax({
        type: "GET",
        url:  "rest/submission/findByStudent/" + this.props.id + "/0",
        async: false,
        success : function(data) {
          grade = data.grade;
          console.log(data);
        }
    });
    return grade;
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
            {self.getGrade()}/{this.props.maxGrade}
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
                        <div className="headerExit" onClick={() => mainSheet.switchTo("assignments")}>X</div>
                        <div className="field">
                          <textarea placeholder="Submission"/>
                        </div>
                        <div className="button" onClick={() => self.submitSubmission()}>SUBMIT</div>
                        <div className="infoCentered">Need help submitting? <span className="link">Click Here.</span></div>
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
    mainSheet.setState(prevState => ({currentPopup: null}));
    this.setState(prevState => ({
      page: pageToSwitchTo
    }));
    console.log("Switched to " + pageToSwitchTo);
  }

  setIsStudent(uservalue){
    var username = $("#usernameSignin").val();
    console.log(username);
    if(username == "Bob") {
      isStudent = true;
      this.switchTo("assignments");
    } else {
      isStudent = false;
      this.switchTo("submissions");
    }
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
                <input type="text" placeholder="Username" id="usernameSignin"/>
                <div className="fieldSplitter"></div>
                <i className="fa fa-user fa-2x" style={{fontSize: '20pt'}}></i>
              </div>
              <div className="field">
                <input type="password" placeholder="Password"/>
                <div className="fieldSplitter"></div>
                <i className="fa fa-key fa-2x" style={{fontSize: '20pt'}}></i>
              </div>
              <div className="button" onClick={() => self.setIsStudent()}>LOG IN</div>
              <div className="infoCentered">New Here? <span className="link" onClick={() => self.switchTo("signup")}>Sign Up!</span></div>
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
              <div className="headerExit" onClick={() => this.switchTo("login")}>X</div>
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
            url: "rest/assignment"  /* "assignmentRestStub"*/ ,
            async: false,
            success : function(data) {
              assignments = data;  /* JSON.parse(data) */ ;
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
              <div className="headerExit" onClick={() => this.switchTo("login")}>X</div>
              {assignments.map(function(obj){
                return <TableLine id={obj.id} courseId={obj.courseId} completed={Math.random() * 100} title={obj.title} dueDate={obj.deadline} grade="4" maxGrade={obj.maxGrade}/>;
              })}
            </div>
          </div>
        );
        break;
      case 'submissions':
        var submissions;

        console.log("Trying rest now");
        $.ajax({
            type: "GET",
            url:  "rest/submission"  /* "submissionRestStub" */,
            async: false,
            success : function(data) {
              submissions = data; /*  JSON.parse(data) */;
            }
        });
        console.log(submissions);

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
              <h2>Submissions</h2>
              <div className="headerExit" onClick={() => this.switchTo("login")}>X</div>
              {submissions.map(function(obj){
                return <TableLineSubmission id={obj.id} user="Bob" course="Example Course"/>;
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
